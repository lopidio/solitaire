/**
 * null
 */
package br.com.guigasgame.solitaire.score.aws.model.transform;

import javax.annotation.Generated;

import com.amazonaws.SdkClientException;
import br.com.guigasgame.solitaire.score.aws.model.*;

import com.amazonaws.protocol.*;
import com.amazonaws.annotation.SdkInternalApi;

/**
 * PostScoresRequestMarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
@SdkInternalApi
public class PostScoresRequestMarshaller {

    private static final MarshallingInfo<StructuredPojo> SCOREMODEL_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
            .marshallLocation(MarshallLocation.PAYLOAD).isExplicitPayloadMember(true).build();

    private static final PostScoresRequestMarshaller instance = new PostScoresRequestMarshaller();

    public static PostScoresRequestMarshaller getInstance() {
        return instance;
    }

    /**
     * Marshall the given parameter object.
     */
    public void marshall(PostScoresRequest postScoresRequest, ProtocolMarshaller protocolMarshaller) {

        if (postScoresRequest == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        try {
            protocolMarshaller.marshall(postScoresRequest.getScoreModel(), SCOREMODEL_BINDING);
        } catch (Exception e) {
            throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
        }
    }

}
