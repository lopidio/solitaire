/**
 * null
 */
package br.com.guigasgame.solitaire.score.aws;

import com.amazonaws.annotation.NotThreadSafe;
import com.amazonaws.client.AwsSyncClientParams;
import com.amazonaws.opensdk.protect.client.SdkSyncClientBuilder;
import com.amazonaws.opensdk.internal.config.ApiGatewayClientConfigurationFactory;
import com.amazonaws.util.RuntimeHttpUtils;
import com.amazonaws.Protocol;

import java.net.URI;
import javax.annotation.Generated;

/**
 * Fluent builder for {@link br.com.guigasgame.solitaire.score.aws.SolitaireService}.
 * 
 * @see br.com.guigasgame.solitaire.score.aws.SolitaireService#builder
 **/
@NotThreadSafe
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public final class SolitaireServiceClientBuilder extends SdkSyncClientBuilder<SolitaireServiceClientBuilder, SolitaireService> {

    private static final URI DEFAULT_ENDPOINT = RuntimeHttpUtils.toUri("j13iw6luq7.execute-api.us-west-2.amazonaws.com", Protocol.HTTPS);
    private static final String DEFAULT_REGION = "us-west-2";

    /**
     * Package private constructor - builder should be created via {@link SolitaireService#builder()}
     */
    SolitaireServiceClientBuilder() {
        super(new ApiGatewayClientConfigurationFactory());
    }

    /**
     * Construct a synchronous implementation of SolitaireService using the current builder configuration.
     *
     * @param params
     *        Current builder configuration represented as a parameter object.
     * @return Fully configured implementation of SolitaireService.
     */
    @Override
    protected SolitaireService build(AwsSyncClientParams params) {
        return new SolitaireServiceClient(params);
    }

    @Override
    protected URI defaultEndpoint() {
        return DEFAULT_ENDPOINT;
    }

    @Override
    protected String defaultRegion() {
        return DEFAULT_REGION;
    }

}
