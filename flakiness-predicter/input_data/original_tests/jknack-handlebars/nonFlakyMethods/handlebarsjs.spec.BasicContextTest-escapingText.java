@Test public void escapingText() throws IOException {
  shouldCompileTo("Awesome's","{}","Awesome's","text is escaped so that it doesn't get caught on single quotes");
  shouldCompileTo("Awesome\\","{}","Awesome\\","text is escaped so that the closing quote can't be ignored");
  shouldCompileTo("Awesome\\\\ foo","{}","Awesome\\\\ foo","text is escaped so that it doesn't mess up backslashes");
  shouldCompileTo("Awesome {{foo}}","{foo: '\\'}","Awesome \\","text is escaped so that it doesn't mess up backslashes");
  shouldCompileTo(" \" \" ","{}"," \" \" ","double quotes never produce invalid javascript");
}
