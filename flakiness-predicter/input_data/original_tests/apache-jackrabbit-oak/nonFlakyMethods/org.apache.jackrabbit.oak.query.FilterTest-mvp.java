@Test public void mvp() throws Exception {
  Filter f=createFilter("//*[(@prop = 'aaa' and @prop = 'bbb' and @prop = 'ccc')]");
  assertFalse(f.isAlwaysFalse());
}
