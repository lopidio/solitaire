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
 * GetScoresRequestMarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
@SdkInternalApi
public class GetScoresRequestMarshaller {

    private static final MarshallingInfo<String> NUM_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.QUERY_PARAM)
            .marshallLocationName("num").build();

    private static final GetScoresRequestMarshaller instance = new GetScoresRequestMarshaller();

    public static GetScoresRequestMarshaller getInstance() {
        return instance;
    }

    /**
     * Marshall the given parameter object.
     */
    public void marshall(GetScoresRequest getScoresRequest, ProtocolMarshaller protocolMarshaller) {

        if (getScoresRequest == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        try {
            protocolMarshaller.marshall(getScoresRequest.getNum(), NUM_BINDING);
        } catch (Exception e) {
            throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
        }
    }

}
