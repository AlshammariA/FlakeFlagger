@Test public void shouldCompileNullScript(){
  assertEquals("(function() {\n\n\n}).call(this);\n",victim.compile(null));
}
