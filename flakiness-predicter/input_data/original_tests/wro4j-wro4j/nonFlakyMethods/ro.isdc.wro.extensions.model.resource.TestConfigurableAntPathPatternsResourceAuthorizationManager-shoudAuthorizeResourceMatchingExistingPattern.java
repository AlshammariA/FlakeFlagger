@Test public void shoudAuthorizeResourceMatchingExistingPattern(){
  victim.setPatterns(Arrays.asList("classpath:com/site/**","/a/b/c/**/*.js"));
  assertTrue(victim.isAuthorized("classpath:com/site/resource/a.js"));
  assertTrue(victim.isAuthorized("/a/b/c/d/e.js"));
}
