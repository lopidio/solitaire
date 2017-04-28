/**
 * null
 */
package br.com.guigasgame.solitaire.score.aws.model.transform;

import java.math.*;

import javax.annotation.Generated;

import br.com.guigasgame.solitaire.score.aws.model.*;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.*;
import com.amazonaws.transform.*;

import com.fasterxml.jackson.core.JsonToken;
import static com.fasterxml.jackson.core.JsonToken.*;

/**
 * ScoresItem JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class ScoresItemJsonUnmarshaller implements Unmarshaller<ScoresItem, JsonUnmarshallerContext> {

    public ScoresItem unmarshall(JsonUnmarshallerContext context) throws Exception {
        ScoresItem scoresItem = new ScoresItem();

        int originalDepth = context.getCurrentDepth();
        String currentParentElement = context.getCurrentParentElement();
        int targetDepth = originalDepth + 1;

        JsonToken token = context.getCurrentToken();
        if (token == null)
            token = context.nextToken();
        if (token == VALUE_NULL) {
            return null;
        }

        while (true) {
            if (token == null)
                break;

            if (token == FIELD_NAME || token == START_OBJECT) {
                if (context.testExpression("awsDate", targetDepth)) {
                    context.nextToken();
                    scoresItem.setAwsDate(context.getUnmarshaller(String.class).unmarshall(context));
                }
                if (context.testExpression("date", targetDepth)) {
                    context.nextToken();
                    scoresItem.setDate(context.getUnmarshaller(String.class).unmarshall(context));
                }
                if (context.testExpression("id", targetDepth)) {
                    context.nextToken();
                    scoresItem.setId(context.getUnmarshaller(String.class).unmarshall(context));
                }
                if (context.testExpression("playerName", targetDepth)) {
                    context.nextToken();
                    scoresItem.setPlayerName(context.getUnmarshaller(String.class).unmarshall(context));
                }
                if (context.testExpression("score", targetDepth)) {
                    context.nextToken();
                    scoresItem.setScore(context.getUnmarshaller(Integer.class).unmarshall(context));
                }
                if (context.testExpression("totalTime", targetDepth)) {
                    context.nextToken();
                    scoresItem.setTotalTime(context.getUnmarshaller(Double.class).unmarshall(context));
                }
                if (context.testExpression("transactionCounter", targetDepth)) {
                    context.nextToken();
                    scoresItem.setTransactionCounter(context.getUnmarshaller(Integer.class).unmarshall(context));
                }
            } else if (token == END_ARRAY || token == END_OBJECT) {
                if (context.getLastParsedParentElement() == null || context.getLastParsedParentElement().equals(currentParentElement)) {
                    if (context.getCurrentDepth() <= originalDepth)
                        break;
                }
            }
            token = context.nextToken();
        }

        return scoresItem;
    }

    private static ScoresItemJsonUnmarshaller instance;

    public static ScoresItemJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new ScoresItemJsonUnmarshaller();
        return instance;
    }
}
