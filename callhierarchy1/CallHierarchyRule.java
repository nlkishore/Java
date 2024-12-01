import net.sourceforge.pmd.lang.java.ast.ASTClassOrInterfaceDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTMethodDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTMethodCall;
import net.sourceforge.pmd.lang.java.rule.AbstractJavaRule;

import java.util.*;

public class CallHierarchyRule extends AbstractJavaRule {

    // Map to store the call hierarchy: Caller -> List of Callees
    private final Map<String, List<String>> callHierarchy = new HashMap<>();

    @Override
    public Object visit(ASTClassOrInterfaceDeclaration node, Object data) {
        String className = node.getImage(); // Get the class name

        // Process all methods in the class
        List<ASTMethodDeclaration> methods = node.findDescendantsOfType(ASTMethodDeclaration.class);
        for (ASTMethodDeclaration method : methods) {
            String methodName = method.getName();
            String caller = className + "." + methodName;

            // Find all method calls within this method
            List<ASTMethodCall> methodCalls = method.findDescendantsOfType(ASTMethodCall.class);
            for (ASTMethodCall methodCall : methodCalls) {
                String callee = methodCall.getMethodName();
                if (callee != null) {
                    callHierarchy.computeIfAbsent(caller, k -> new ArrayList<>()).add(callee);
                }
            }
        }

        return super.visit(node, data);
    }

    @Override
    public Object visit(ASTMethodDeclaration node, Object data) {
        // Optional: Add additional logic to handle methods directly
        return super.visit(node, data);
    }

    @Override
    public void end(RuleContext ctx) {
        // Output the call hierarchy
        callHierarchy.forEach((caller, callees) -> {
            StringBuilder output = new StringBuilder(caller + " calls: ");
            output.append(String.join(", ", callees));
            ctx.getReport().addRuleViolation(
                createViolation(ctx, 0, output.toString())
            );
        });

        super.end(ctx);
    }
}
