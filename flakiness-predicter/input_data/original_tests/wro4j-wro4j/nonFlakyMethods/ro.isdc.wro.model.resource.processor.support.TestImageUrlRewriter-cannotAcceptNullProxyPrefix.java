@Test(expected=NullPointerException.class) public void cannotAcceptNullProxyPrefix(){
  final RewriterContext context=new RewriterContext();
  context.setContextPath(DEFAULT_CONTEXT_PATH);
  new ImageUrlRewriter(context);
}
