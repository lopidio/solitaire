/**
 * null
 */
package br.com.guigasgame.solitaire.score.aws;

import java.util.Arrays;

import javax.annotation.Generated;

import com.amazonaws.SdkBaseException;
import com.amazonaws.annotation.ThreadSafe;
import com.amazonaws.client.AwsSyncClientParams;
import com.amazonaws.client.ClientExecutionParams;
import com.amazonaws.client.ClientHandler;
import com.amazonaws.client.ClientHandlerParams;
import com.amazonaws.http.HttpResponseHandler;
import com.amazonaws.opensdk.protect.client.SdkClientHandler;
import com.amazonaws.protocol.json.JsonClientMetadata;
import com.amazonaws.protocol.json.JsonErrorResponseMetadata;
import com.amazonaws.protocol.json.JsonErrorShapeMetadata;
import com.amazonaws.protocol.json.JsonOperationMetadata;

import br.com.guigasgame.solitaire.score.aws.model.GetScoresRequest;
import br.com.guigasgame.solitaire.score.aws.model.GetScoresResult;
import br.com.guigasgame.solitaire.score.aws.model.GetScoresScoreidRequest;
import br.com.guigasgame.solitaire.score.aws.model.GetScoresScoreidResult;
import br.com.guigasgame.solitaire.score.aws.model.PostScoresRequest;
import br.com.guigasgame.solitaire.score.aws.model.PostScoresResult;
import br.com.guigasgame.solitaire.score.aws.model.transform.GetScoresRequestProtocolMarshaller;
import br.com.guigasgame.solitaire.score.aws.model.transform.GetScoresResultJsonUnmarshaller;
import br.com.guigasgame.solitaire.score.aws.model.transform.GetScoresScoreidRequestProtocolMarshaller;
import br.com.guigasgame.solitaire.score.aws.model.transform.GetScoresScoreidResultJsonUnmarshaller;
import br.com.guigasgame.solitaire.score.aws.model.transform.PostScoresRequestProtocolMarshaller;
import br.com.guigasgame.solitaire.score.aws.model.transform.PostScoresResultJsonUnmarshaller;

/**
 * Client for accessing SolitaireService. All service calls made using this client are blocking, and will not return
 * until the service call completes.
 * <p>
 * 
 */
@ThreadSafe
@Generated("com.amazonaws:aws-java-sdk-code-generator")
class SolitaireServiceClient implements SolitaireService {

    private final ClientHandler clientHandler;

    private final com.amazonaws.opensdk.protect.protocol.ApiGatewayProtocolFactoryImpl protocolFactory = new com.amazonaws.opensdk.protect.protocol.ApiGatewayProtocolFactoryImpl(
            new JsonClientMetadata().withProtocolVersion("1.1").withSupportsCbor(false).withSupportsIon(false).withContentTypeOverride("application/json")
                    .withBaseServiceExceptionClass(br.com.guigasgame.solitaire.score.aws.model.SolitaireServiceException.class));

    /**
     * Constructs a new client to invoke service methods on SolitaireService using the specified parameters.
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not return until the service call
     * completes.
     *
     * @param clientParams
     *        Object providing client parameters.
     */
    SolitaireServiceClient(AwsSyncClientParams clientParams) {
        this.clientHandler = new SdkClientHandler(new ClientHandlerParams().withClientParams(clientParams));
    }

    /**
     * @param getScoresRequest
     * @return Result of the GetScores operation returned by the service.
     * @sample SolitaireService.GetScores
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/j13iw6luq7-2017-04-28T02:31:35Z/GetScores" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public GetScoresResult getScores(GetScoresRequest getScoresRequest) {
        HttpResponseHandler<GetScoresResult> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata().withPayloadJson(true)
                .withHasStreamingSuccessResponse(false), new GetScoresResultJsonUnmarshaller());

        HttpResponseHandler<SdkBaseException> errorResponseHandler = createErrorResponseHandler();

        return clientHandler.execute(new ClientExecutionParams<GetScoresRequest, GetScoresResult>()
                .withMarshaller(new GetScoresRequestProtocolMarshaller(protocolFactory)).withResponseHandler(responseHandler)
                .withErrorResponseHandler(errorResponseHandler).withInput(getScoresRequest));
    }

    /**
     * @param getScoresScoreidRequest
     * @return Result of the GetScoresScoreid operation returned by the service.
     * @sample SolitaireService.GetScoresScoreid
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/j13iw6luq7-2017-04-28T02:31:35Z/GetScoresScoreid"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public GetScoresScoreidResult getScoresScoreid(GetScoresScoreidRequest getScoresScoreidRequest) {
        HttpResponseHandler<GetScoresScoreidResult> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata().withPayloadJson(true)
                .withHasStreamingSuccessResponse(false), new GetScoresScoreidResultJsonUnmarshaller());

        HttpResponseHandler<SdkBaseException> errorResponseHandler = createErrorResponseHandler();

        return clientHandler.execute(new ClientExecutionParams<GetScoresScoreidRequest, GetScoresScoreidResult>()
                .withMarshaller(new GetScoresScoreidRequestProtocolMarshaller(protocolFactory)).withResponseHandler(responseHandler)
                .withErrorResponseHandler(errorResponseHandler).withInput(getScoresScoreidRequest));
    }

    /**
     * @param postScoresRequest
     * @return Result of the PostScores operation returned by the service.
     * @sample SolitaireService.PostScores
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/j13iw6luq7-2017-04-28T02:31:35Z/PostScores"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public PostScoresResult postScores(PostScoresRequest postScoresRequest) {
        HttpResponseHandler<PostScoresResult> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata().withPayloadJson(true)
                .withHasStreamingSuccessResponse(false), new PostScoresResultJsonUnmarshaller());

        HttpResponseHandler<SdkBaseException> errorResponseHandler = createErrorResponseHandler();

        return clientHandler.execute(new ClientExecutionParams<PostScoresRequest, PostScoresResult>()
                .withMarshaller(new PostScoresRequestProtocolMarshaller(protocolFactory)).withResponseHandler(responseHandler)
                .withErrorResponseHandler(errorResponseHandler).withInput(postScoresRequest));
    }

    /**
     * Create the error response handler for the operation.
     * 
     * @param errorShapeMetadata
     *        Error metadata for the given operation
     * @return Configured error response handler to pass to HTTP layer
     */
    private HttpResponseHandler<SdkBaseException> createErrorResponseHandler(JsonErrorShapeMetadata... errorShapeMetadata) {
        return protocolFactory.createErrorResponseHandler(new JsonErrorResponseMetadata().withErrorShapes(Arrays.asList(errorShapeMetadata)));
    }

    @Override
    public void shutdown() {
        clientHandler.shutdown();
    }

}
