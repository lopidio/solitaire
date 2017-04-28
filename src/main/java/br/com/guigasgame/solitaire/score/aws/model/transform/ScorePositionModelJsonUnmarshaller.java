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
 * ScorePositionModel JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class ScorePositionModelJsonUnmarshaller implements Unmarshaller<ScorePositionModel, JsonUnmarshallerContext> {

    public ScorePositionModel unmarshall(JsonUnmarshallerContext context) throws Exception {
        ScorePositionModel scorePositionModel = new ScorePositionModel();

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
                if (context.testExpression("index", targetDepth)) {
                    context.nextToken();
                    scorePositionModel.setIndex(context.getUnmarshaller(Integer.class).unmarshall(context));
                }
                if (context.testExpression("itemId", targetDepth)) {
                    context.nextToken();
                    scorePositionModel.setItemId(context.getUnmarshaller(String.class).unmarshall(context));
                }
                if (context.testExpression("total", targetDepth)) {
                    context.nextToken();
                    scorePositionModel.setTotal(context.getUnmarshaller(Integer.class).unmarshall(context));
                }
            } else if (token == END_ARRAY || token == END_OBJECT) {
                if (context.getLastParsedParentElement() == null || context.getLastParsedParentElement().equals(currentParentElement)) {
                    if (context.getCurrentDepth() <= originalDepth)
                        break;
                }
            }
            token = context.nextToken();
        }

        return scorePositionModel;
    }

    private static ScorePositionModelJsonUnmarshaller instance;

    public static ScorePositionModelJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new ScorePositionModelJsonUnmarshaller();
        return instance;
    }
}
