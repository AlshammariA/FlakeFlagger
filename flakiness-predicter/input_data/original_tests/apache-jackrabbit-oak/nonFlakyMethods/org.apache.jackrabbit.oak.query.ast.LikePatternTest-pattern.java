private static void pattern(String pattern,String match,String noMatch,String lower,String upper){
  LikePattern p=new LikePattern(pattern);
  if (match != null) {
    assertTrue(p.matches(match));
  }
  if (noMatch != null) {
    assertFalse(p.matches(noMatch));
  }
  assertEquals(lower,p.getLowerBound());
  assertEquals(upper,p.getUpperBound());
}
