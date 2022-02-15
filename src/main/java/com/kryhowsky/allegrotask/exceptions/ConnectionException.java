package com.kryhowsky.allegrotask.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ConnectionException extends RuntimeException {

    public ConnectionException(String message) {
        super(message);
    }

}
