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
 * ScoreListModel JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class ScoreListModelJsonUnmarshaller implements Unmarshaller<ScoreListModel, JsonUnmarshallerContext> {

    public ScoreListModel unmarshall(JsonUnmarshallerContext context) throws Exception {
        ScoreListModel scoreListModel = new ScoreListModel();

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
                if (context.testExpression("scores", targetDepth)) {
                    context.nextToken();
                    scoreListModel.setScores(new ListUnmarshaller<ScoresItem>(ScoresItemJsonUnmarshaller.getInstance()).unmarshall(context));
                }
            } else if (token == END_ARRAY || token == END_OBJECT) {
                if (context.getLastParsedParentElement() == null || context.getLastParsedParentElement().equals(currentParentElement)) {
                    if (context.getCurrentDepth() <= originalDepth)
                        break;
                }
            }
            token = context.nextToken();
        }

        return scoreListModel;
    }

    private static ScoreListModelJsonUnmarshaller instance;

    public static ScoreListModelJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new ScoreListModelJsonUnmarshaller();
        return instance;
    }
}
