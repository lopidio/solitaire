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
 * ScoreModelMarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
@SdkInternalApi
public class ScoreModelMarshaller {

    private static final MarshallingInfo<Integer> DATE_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER).marshallLocation(MarshallLocation.PAYLOAD)
            .marshallLocationName("date").build();
    private static final MarshallingInfo<String> PLAYERNAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
            .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("playerName").build();
    private static final MarshallingInfo<Integer> SCORE_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER).marshallLocation(MarshallLocation.PAYLOAD)
            .marshallLocationName("score").build();
    private static final MarshallingInfo<Double> TOTALTIME_BINDING = MarshallingInfo.builder(MarshallingType.DOUBLE).marshallLocation(MarshallLocation.PAYLOAD)
            .marshallLocationName("totalTime").build();
    private static final MarshallingInfo<Integer> TRANSACTIONCOUNTER_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER)
            .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("transactionCounter").build();

    private static final ScoreModelMarshaller instance = new ScoreModelMarshaller();

    public static ScoreModelMarshaller getInstance() {
        return instance;
    }

    /**
     * Marshall the given parameter object.
     */
    public void marshall(ScoreModel scoreModel, ProtocolMarshaller protocolMarshaller) {

        if (scoreModel == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        try {
            protocolMarshaller.marshall(scoreModel.getDate(), DATE_BINDING);
            protocolMarshaller.marshall(scoreModel.getPlayerName(), PLAYERNAME_BINDING);
            protocolMarshaller.marshall(scoreModel.getScore(), SCORE_BINDING);
            protocolMarshaller.marshall(scoreModel.getTotalTime(), TOTALTIME_BINDING);
            protocolMarshaller.marshall(scoreModel.getTransactionCounter(), TRANSACTIONCOUNTER_BINDING);
        } catch (Exception e) {
            throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
        }
    }

}
