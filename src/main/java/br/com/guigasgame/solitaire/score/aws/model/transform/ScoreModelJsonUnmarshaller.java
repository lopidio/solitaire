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
 * ScoreModel JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class ScoreModelJsonUnmarshaller implements Unmarshaller<ScoreModel, JsonUnmarshallerContext> {

    public ScoreModel unmarshall(JsonUnmarshallerContext context) throws Exception {
        ScoreModel scoreModel = new ScoreModel();

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
                if (context.testExpression("date", targetDepth)) {
                    context.nextToken();
                    scoreModel.setDate(context.getUnmarshaller(Integer.class).unmarshall(context));
                }
                if (context.testExpression("playerName", targetDepth)) {
                    context.nextToken();
                    scoreModel.setPlayerName(context.getUnmarshaller(String.class).unmarshall(context));
                }
                if (context.testExpression("score", targetDepth)) {
                    context.nextToken();
                    scoreModel.setScore(context.getUnmarshaller(Integer.class).unmarshall(context));
                }
                if (context.testExpression("totalTime", targetDepth)) {
                    context.nextToken();
                    scoreModel.setTotalTime(context.getUnmarshaller(Double.class).unmarshall(context));
                }
                if (context.testExpression("transactionCounter", targetDepth)) {
                    context.nextToken();
                    scoreModel.setTransactionCounter(context.getUnmarshaller(Integer.class).unmarshall(context));
                }
            } else if (token == END_ARRAY || token == END_OBJECT) {
                if (context.getLastParsedParentElement() == null || context.getLastParsedParentElement().equals(currentParentElement)) {
                    if (context.getCurrentDepth() <= originalDepth)
                        break;
                }
            }
            token = context.nextToken();
        }

        return scoreModel;
    }

    private static ScoreModelJsonUnmarshaller instance;

    public static ScoreModelJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new ScoreModelJsonUnmarshaller();
        return instance;
    }
}
