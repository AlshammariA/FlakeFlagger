@Test public void shouldCompileNullContent(){
  assertEquals("(function(){dust.register(null,body_0);function body_0(chk,ctx){return chk;}return body_0;})();",victim.compile(null,null));
}
