package fortifiedid.bankidapi.environment;

public class EnvironmentCustom implements Environment {

    private final String url;

    public EnvironmentCustom(String url) {

	this.url = url;
    }

    @Override
    public String getWebServiceUrl() {
	return url;
    }
}
