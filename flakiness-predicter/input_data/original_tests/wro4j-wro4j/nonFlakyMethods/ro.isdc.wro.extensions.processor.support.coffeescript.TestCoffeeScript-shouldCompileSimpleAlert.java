@Test public void shouldCompileSimpleAlert(){
  assertEquals("(function() {\n  alert('I knew it!');\n\n}).call(this);\n",victim.compile("alert 'I knew it!'"));
}
