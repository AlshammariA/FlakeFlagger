@Test public void thatCurrentContextPathDoesnotHitHelpers() throws IOException {
  shouldCompileTo("test: {{.}}",(Object)null,$("helper","awesome"),"test: ");
}
