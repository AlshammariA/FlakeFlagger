@Test public void spacesInVar() throws IOException {
  shouldCompileTo("{{var}}",$,"");
  shouldCompileTo("{{ var}}",$,"");
  shouldCompileTo("{{var }}",$,"");
  shouldCompileTo("{{ var }}",$,"");
  shouldCompileTo("{{var x }}",$,$("var",""),"");
}
