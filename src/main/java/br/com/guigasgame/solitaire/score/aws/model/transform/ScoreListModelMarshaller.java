/**
 * null
 */
package br.com.guigasgame.solitaire.score.aws.model.transform;

import java.util.List;
import javax.annotation.Generated;

import com.amazonaws.SdkClientException;
import br.com.guigasgame.solitaire.score.aws.model.*;

import com.amazonaws.protocol.*;
import com.amazonaws.annotation.SdkInternalApi;

/**
 * ScoreListModelMarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
@SdkInternalApi
public class ScoreListModelMarshaller {

    private static final MarshallingInfo<List> SCORES_BINDING = MarshallingInfo.builder(MarshallingType.LIST).marshallLocation(MarshallLocation.PAYLOAD)
            .marshallLocationName("scores").build();

    private static final ScoreListModelMarshaller instance = new ScoreListModelMarshaller();

    public static ScoreListModelMarshaller getInstance() {
        return instance;
    }

    /**
     * Marshall the given parameter object.
     */
    public void marshall(ScoreListModel scoreListModel, ProtocolMarshaller protocolMarshaller) {

        if (scoreListModel == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        try {
            protocolMarshaller.marshall(scoreListModel.getScores(), SCORES_BINDING);
        } catch (Exception e) {
            throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
        }
    }

}
