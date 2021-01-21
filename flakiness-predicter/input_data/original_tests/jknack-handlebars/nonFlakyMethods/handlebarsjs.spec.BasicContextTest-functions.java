@Test @SuppressWarnings("unused") public void functions() throws IOException {
  shouldCompileTo("{{awesome}}",new Object(){
    public Object getAwesome(){
      return "Awesome";
    }
  }
,"Awesome","functions are called and render their output");
  shouldCompileTo("{{awesome}}",new Object(){
    String more="More awesome";
    public Object getAwesome(){
      return more;
    }
  }
,"More awesome","functions are called and render their output");
}
