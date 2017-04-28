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
 * GetScoresScoreidRequestMarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
@SdkInternalApi
public class GetScoresScoreidRequestMarshaller {

    private static final MarshallingInfo<String> SCOREID_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PATH)
            .marshallLocationName("scoreid").build();

    private static final GetScoresScoreidRequestMarshaller instance = new GetScoresScoreidRequestMarshaller();

    public static GetScoresScoreidRequestMarshaller getInstance() {
        return instance;
    }

    /**
     * Marshall the given parameter object.
     */
    public void marshall(GetScoresScoreidRequest getScoresScoreidRequest, ProtocolMarshaller protocolMarshaller) {

        if (getScoresScoreidRequest == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        try {
            protocolMarshaller.marshall(getScoresScoreidRequest.getScoreid(), SCOREID_BINDING);
        } catch (Exception e) {
            throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
        }
    }

}
