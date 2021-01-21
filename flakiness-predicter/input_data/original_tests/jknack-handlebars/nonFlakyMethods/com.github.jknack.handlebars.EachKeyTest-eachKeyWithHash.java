@Test public void eachKeyWithHash() throws IOException {
  Map<String,Object> hash=new LinkedHashMap<String,Object>();
  hash.put("body","...");
  hash.put("title","Handlebars.java");
  shouldCompileTo("{{#each this}}{{@key}}: {{this}} {{/each}}",hash,"body: ... title: Handlebars.java ");
}
