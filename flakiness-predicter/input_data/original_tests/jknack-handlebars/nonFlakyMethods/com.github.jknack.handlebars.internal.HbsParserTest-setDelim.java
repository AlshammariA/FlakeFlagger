@Test public void setDelim(){
  parse("{{=<% %>=}}<%hello%><%={{ }}=%>{{reset}}");
  parse("{{= | | =}}<|#lambda|-|/lambda|>");
  parse("{{=+-+ -+-=}}+-+test-+-");
}
