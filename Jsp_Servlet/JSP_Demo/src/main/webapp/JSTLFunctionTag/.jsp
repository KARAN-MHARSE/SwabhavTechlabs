<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>JSTL Functions Example</title>
</head>
<body>
    <h2>JSTL Functions Demo with Name: "Karan Mharse"</h2>

    <p><b>Original String:</b> ${"Karan Mharse"}</p>

    <p>1. Length: ${fn:length("Karan Mharse")}</p>
    <p>2. To Upper Case: ${fn:toUpperCase("Karan Mharse")}</p>
    <p>3. To Lower Case: ${fn:toLowerCase("Karan Mharse")}</p>
    <p>4. Trim (no effect here): ${fn:trim("   Karan Mharse   ")}</p>
    <p>5. Contains 'Mharse'? ${fn:contains("Karan Mharse", "Mharse")}</p>
    <p>6. ContainsIgnoreCase 'karan'? ${fn:containsIgnoreCase("Karan Mharse", "karan")}</p>
    <p>7. Starts with 'Kar'? ${fn:startsWith("Karan Mharse", "Kar")}</p>
    <p>8. Ends with 'se'? ${fn:endsWith("Karan Mharse", "se")}</p>
    <p>9. Index of 'Mharse': ${fn:indexOf("Karan Mharse", "Mharse")}</p>
    <p>10. Replace 'Mharse' with 'Developer': ${fn:replace("Karan Mharse", "Mharse", "Developer")}</p>
    <p>11. Substring (0–5): ${fn:substring("Karan Mharse", 0, 5)}</p>
    <p>12. Substring After space: ${fn:substringAfter("Karan Mharse", " ")}</p>
    <p>13. Substring Before space: ${fn:substringBefore("Karan Mharse", " ")}</p>

    <h3>Split Example</h3>
    <c:forEach var="part" items="${fn:split('Karan Mharse',' ')}">
        <p>Part: ${part}</p>
    </c:forEach>

    <h3>Join Example</h3>
    <p>${fn:join(fn:split("Karan,Mharse,Java,Developer", ","), " - ")}</p>
</body>
</html>
