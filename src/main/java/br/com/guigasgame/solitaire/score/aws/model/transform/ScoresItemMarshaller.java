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
 * ScoresItemMarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
@SdkInternalApi
public class ScoresItemMarshaller {

    private static final MarshallingInfo<String> AWSDATE_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
            .marshallLocationName("awsDate").build();
    private static final MarshallingInfo<String> DATE_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
            .marshallLocationName("date").build();
    private static final MarshallingInfo<String> ID_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
            .marshallLocationName("id").build();
    private static final MarshallingInfo<String> PLAYERNAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
            .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("playerName").build();
    private static final MarshallingInfo<Integer> SCORE_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER).marshallLocation(MarshallLocation.PAYLOAD)
            .marshallLocationName("score").build();
    private static final MarshallingInfo<Double> TOTALTIME_BINDING = MarshallingInfo.builder(MarshallingType.DOUBLE).marshallLocation(MarshallLocation.PAYLOAD)
            .marshallLocationName("totalTime").build();
    private static final MarshallingInfo<Integer> TRANSACTIONCOUNTER_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER)
            .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("transactionCounter").build();

    private static final ScoresItemMarshaller instance = new ScoresItemMarshaller();

    public static ScoresItemMarshaller getInstance() {
        return instance;
    }

    /**
     * Marshall the given parameter object.
     */
    public void marshall(ScoresItem scoresItem, ProtocolMarshaller protocolMarshaller) {

        if (scoresItem == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        try {
            protocolMarshaller.marshall(scoresItem.getAwsDate(), AWSDATE_BINDING);
            protocolMarshaller.marshall(scoresItem.getDate(), DATE_BINDING);
            protocolMarshaller.marshall(scoresItem.getId(), ID_BINDING);
            protocolMarshaller.marshall(scoresItem.getPlayerName(), PLAYERNAME_BINDING);
            protocolMarshaller.marshall(scoresItem.getScore(), SCORE_BINDING);
            protocolMarshaller.marshall(scoresItem.getTotalTime(), TOTALTIME_BINDING);
            protocolMarshaller.marshall(scoresItem.getTransactionCounter(), TRANSACTIONCOUNTER_BINDING);
        } catch (Exception e) {
            throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
        }
    }

}
