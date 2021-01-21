@Test public void eachWithHash() throws IOException {
  String string="{{#each goodbyes}}{{@key}}. {{text}}! {{/each}}cruel {{world}}!";
  Object hash=$("goodbyes",$("<b>#1</b>",$("text","goodbye"),"2",$("text","GOODBYE")),"world","world");
  shouldCompileTo(string,hash,"&lt;b&gt;#1&lt;/b&gt;. goodbye! 2. GOODBYE! cruel world!");
}
