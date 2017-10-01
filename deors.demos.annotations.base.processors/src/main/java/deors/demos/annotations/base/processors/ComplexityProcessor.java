package deors.demos.annotations.base.processors;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

import deors.demos.annotations.base.Author;
import deors.demos.annotations.base.Complexity;

/**
 * Annotation processor for Complexity annotation type.
 *
 * @author deors
 * @version 1.0
 */
@SupportedAnnotationTypes({"deors.demos.annotations.base.Complexity", "deors.demos.annotations.base.Author"})
@SupportedSourceVersion(SourceVersion.RELEASE_9)
public class ComplexityProcessor
    extends AbstractProcessor {

    /**
     * Default constructor.
     */
    public ComplexityProcessor() {

        super();
    }

    /**
     * Reads the complexity value contained in the annotation and prints it in the console
     * (NOTE level).
     *
     * @param annotations set of annotations found
     * @param roundEnv the environment for this processor round
     *
     * @return whether a new processor round would be needed
     */
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
	
        for (Element elem : roundEnv.getElementsAnnotatedWithAny(getAnnotationTypes())) {
        
        	for (Complexity c : elem.getAnnotationsByType(Complexity.class)) {
	
	            String message = "Annotation found in " + elem.getSimpleName()
	                + " with complexity " + c.value();
	            processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, message);
        	}
        	
        	for (Author a : elem.getAnnotationsByType(Author.class)) {
        		
        		String message = "Annotation found in " + elem.getSimpleName()
        			+ " from author " + a.name();
        		processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, message);
        	}
        }

        return true;
    }
    
    
    /**
     * Returns the annotation types to consider
     * @return annotation types to consider
     */
    private Set<Class<? extends Annotation>> getAnnotationTypes() {
    	Set<Class<? extends Annotation>> annotationTypes = new HashSet<>();
    	annotationTypes.add(Complexity.class);
    	annotationTypes.add(Author.class);
    	return annotationTypes;
    }
}
