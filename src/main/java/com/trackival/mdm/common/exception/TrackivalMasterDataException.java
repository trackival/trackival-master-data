package com.trackival.mdm.common.exception;

public class TrackivalMasterDataException extends RuntimeException {
    public TrackivalMasterDataException() {
    }

    public TrackivalMasterDataException(String message) {
        super(message);
    }

    public TrackivalMasterDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public TrackivalMasterDataException(Throwable cause) {
        super(cause);
    }

    public TrackivalMasterDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
