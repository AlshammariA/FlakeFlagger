@Test public void blockInvertedSections() throws IOException {
  shouldCompileTo("{{#people}}{{name}}{{^}}{{none}}{{/people}}","{none: No people}","No people");
}
