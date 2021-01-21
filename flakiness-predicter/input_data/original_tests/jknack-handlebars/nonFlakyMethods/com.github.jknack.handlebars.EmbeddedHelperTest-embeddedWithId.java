@Test public void embeddedWithId() throws IOException {
  String expected="<html>\n";
  expected+="...\n";
  expected+="<script id=\"user-tmpl\" type=\"text/x-handlebars\">\n";
  expected+="<tr>\n";
  expected+="  <td>{{firstName}}</td>\n";
  expected+="  <td>{{lastName}}</td>\n";
  expected+="</tr>\n";
  expected+="</script>\n";
  expected+="...\n";
  expected+="</html>";
  String input="<html>\n";
  input+="...\n";
  input+="{{embedded \"user\" \"user-tmpl\"}}\n";
  input+="...\n";
  input+="</html>";
  Hash partials=$("user","<tr>\n" + "  <td>{{firstName}}</td>\n" + "  <td>{{lastName}}</td>\n"+ "</tr>");
  shouldCompileToWithPartials(input,$,partials,expected);
}
