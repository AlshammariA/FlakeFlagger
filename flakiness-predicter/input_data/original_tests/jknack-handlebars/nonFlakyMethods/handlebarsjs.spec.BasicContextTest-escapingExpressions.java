@Test public void escapingExpressions() throws IOException {
  shouldCompileTo("{{{awesome}}}","{awesome: '&\"\\<>'}","&\"\\<>","expressions with 3 handlebars aren't escaped");
  shouldCompileTo("{{&awesome}}","{awesome: '&\"\\<>'}","&\"\\<>","expressions with {{& handlebars aren't escaped");
  shouldCompileTo("{{awesome}}",$("awesome","&\"'`\\<>"),"&amp;&quot;&#x27;&#x60;\\&lt;&gt;","by default expressions should be escaped");
  shouldCompileTo("{{awesome}}","{awesome: 'Escaped, <b> looks like: &lt;b&gt;'}","Escaped, &lt;b&gt; looks like: &amp;lt;b&amp;gt;","escaping should properly handle amperstands");
}
