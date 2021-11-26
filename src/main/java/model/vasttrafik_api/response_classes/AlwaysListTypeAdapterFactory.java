package model.vasttrafik_api.response_classes;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public final class AlwaysListTypeAdapterFactory<E> implements TypeAdapterFactory {

    private AlwaysListTypeAdapterFactory() {}

    @Override
    public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> typeToken) {
        if (!List.class.isAssignableFrom(typeToken.getRawType())) {
            return null;
        }
        final Type elementType = resolveTypeArgument(typeToken.getType());

        @SuppressWarnings("unchecked")
        final TypeAdapter<E> elementTypeAdapter = (TypeAdapter<E>) gson.getAdapter(TypeToken.get(elementType));

        @SuppressWarnings("unchecked")
        final TypeAdapter<T> alwaysListTypeAdapter = (TypeAdapter<T>) new AlwaysListTypeAdapter<>(elementTypeAdapter).nullSafe();
        return alwaysListTypeAdapter;
    }

    private static Type resolveTypeArgument(final Type type) {
        if (!(type instanceof final ParameterizedType parameterizedType)) {
            return Object.class;
        }
        return parameterizedType.getActualTypeArguments()[0];
    }

    private static final class AlwaysListTypeAdapter<E> extends TypeAdapter<List<E>> {
        private final TypeAdapter<E> elementTypeAdapter;

        private AlwaysListTypeAdapter(final TypeAdapter<E> elementTypeAdapter) {
            this.elementTypeAdapter = elementTypeAdapter;
        }

        @Override
        public void write(JsonWriter out, List<E> value) throws IOException {
            throw new UnsupportedOperationException();
        }

        @Override
        public List<E> read(JsonReader in)
                throws IOException {
            final List<E> list = new ArrayList<>();
            final JsonToken token = in.peek();
            switch (token) {
                case BEGIN_ARRAY -> {
                    in.beginArray();
                    while (in.hasNext())
                        list.add(elementTypeAdapter.read(in));
                    in.endArray();
                }
                case BEGIN_OBJECT, STRING, NUMBER, BOOLEAN -> list.add(elementTypeAdapter.read(in));
                case NULL -> throw new AssertionError("no bueno");
                case NAME, END_ARRAY, END_OBJECT, END_DOCUMENT -> throw new MalformedJsonException("Unexpected token: " + token);
                default -> throw new AssertionError("Must never happen: " + token);
            }
            return list;
        }
    }
}