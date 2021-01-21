@Test public void exceptionErrorWithCommittedResponse() throws Exception {
  this.filter.addErrorPages(new ErrorPage(RuntimeException.class,"/500"));
  this.chain=new MockFilterChain(){
    @Override public void doFilter(    ServletRequest request,    ServletResponse response) throws IOException, ServletException {
      super.doFilter(request,response);
      response.flushBuffer();
      throw new RuntimeException("BAD");
    }
  }
;
  this.filter.doFilter(this.request,this.response,this.chain);
  assertThat(this.response.getForwardedUrl(),is(nullValue()));
}
