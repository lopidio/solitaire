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
 * ScorePositionModelMarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
@SdkInternalApi
public class ScorePositionModelMarshaller {

    private static final MarshallingInfo<Integer> INDEX_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER).marshallLocation(MarshallLocation.PAYLOAD)
            .marshallLocationName("index").build();
    private static final MarshallingInfo<String> ITEMID_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
            .marshallLocationName("itemId").build();
    private static final MarshallingInfo<Integer> TOTAL_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER).marshallLocation(MarshallLocation.PAYLOAD)
            .marshallLocationName("total").build();

    private static final ScorePositionModelMarshaller instance = new ScorePositionModelMarshaller();

    public static ScorePositionModelMarshaller getInstance() {
        return instance;
    }

    /**
     * Marshall the given parameter object.
     */
    public void marshall(ScorePositionModel scorePositionModel, ProtocolMarshaller protocolMarshaller) {

        if (scorePositionModel == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        try {
            protocolMarshaller.marshall(scorePositionModel.getIndex(), INDEX_BINDING);
            protocolMarshaller.marshall(scorePositionModel.getItemId(), ITEMID_BINDING);
            protocolMarshaller.marshall(scorePositionModel.getTotal(), TOTAL_BINDING);
        } catch (Exception e) {
            throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
        }
    }

}
