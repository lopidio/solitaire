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
 * ScoreIdModel JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class ScoreIdModelJsonUnmarshaller implements Unmarshaller<ScoreIdModel, JsonUnmarshallerContext> {

    public ScoreIdModel unmarshall(JsonUnmarshallerContext context) throws Exception {
        ScoreIdModel scoreIdModel = new ScoreIdModel();

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
                if (context.testExpression("itemId", targetDepth)) {
                    context.nextToken();
                    scoreIdModel.setItemId(context.getUnmarshaller(String.class).unmarshall(context));
                }
            } else if (token == END_ARRAY || token == END_OBJECT) {
                if (context.getLastParsedParentElement() == null || context.getLastParsedParentElement().equals(currentParentElement)) {
                    if (context.getCurrentDepth() <= originalDepth)
                        break;
                }
            }
            token = context.nextToken();
        }

        return scoreIdModel;
    }

    private static ScoreIdModelJsonUnmarshaller instance;

    public static ScoreIdModelJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new ScoreIdModelJsonUnmarshaller();
        return instance;
    }
}
