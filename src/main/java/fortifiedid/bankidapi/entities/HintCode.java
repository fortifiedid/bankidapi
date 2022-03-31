package fortifiedid.bankidapi.entities;

public enum HintCode
{
    OUTSTANDING_TRANSACTION("outstandingTransaction"),
    NO_CLIENT("noClient"),
    STARTED("started"),
    USER_SIGN("userSign"),

    EXPIRED_TRANSACTION("expiredTransaction"),
    CERTIFICATE_ERR("certificateErr"),
    USER_CANCEL("userCancel"),
    CANCELLED("cancelled"),
    START_FAILED("startFailed"),

    UNKNOWN("unknown");

    private final String hintCode;
    HintCode(String hintCode)
    {
        this.hintCode = hintCode;
    }

    public static HintCode parse(String name)
    {
        for(HintCode hintCode : values())
            if(hintCode.toString().equals(name))
                return hintCode;

        return UNKNOWN;
    }

    @Override
    public String toString()
    {
        return hintCode;
    }
}
