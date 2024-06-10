#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.allison1875.serviceimpl.persistencegenerator;

import java.util.regex.Pattern;
import com.google.inject.Singleton;
import com.spldeolin.allison1875.persistencegenerator.javabean.InformationSchemaDto;
import com.spldeolin.allison1875.persistencegenerator.service.impl.CommentServiceImpl;

/**
 * @author Deolin 2021-05-24
 */
@Singleton
public class CommentServiceImpl2 extends CommentServiceImpl {

    @Override
    public String analyzeColumnComment(InformationSchemaDto infoSchema) {
        String comment = super.analyzeColumnComment(infoSchema);

        comment = Pattern.compile("T${symbol_escape}${symbol_escape}((.+?)${symbol_escape}${symbol_escape})").matcher(comment).replaceFirst("").trim();
        comment = Pattern.compile("E${symbol_escape}${symbol_escape}((.+?)${symbol_escape}${symbol_escape})").matcher(comment).replaceFirst("").trim();

        return comment;
    }

}