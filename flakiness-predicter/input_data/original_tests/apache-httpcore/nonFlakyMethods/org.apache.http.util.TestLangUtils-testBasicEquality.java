@Test public void testBasicEquality(){
  Assert.assertTrue(LangUtils.equals(null,null));
  Assert.assertFalse(LangUtils.equals(null,"abc"));
  Assert.assertFalse(LangUtils.equals("abc",null));
  Assert.assertTrue(LangUtils.equals("abc","abc"));
}
