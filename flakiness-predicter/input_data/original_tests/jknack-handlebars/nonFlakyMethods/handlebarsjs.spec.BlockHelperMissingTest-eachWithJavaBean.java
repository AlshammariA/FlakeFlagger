@Test @SuppressWarnings("unused") public void eachWithJavaBean() throws IOException {
  String string="{{#each goodbyes}}{{@key}}. {{text}}! {{/each}}cruel {{world}}!";
  Object hash=new Object(){
    public Object getGoodbyes(){
      return new Object(){
        public Object getB1(){
          return new Object(){
            public String getText(){
              return "goodbye";
            }
          }
;
        }
        public Object get2(){
          return new Object(){
            public String getText(){
              return "GOODBYE";
            }
          }
;
        }
      }
;
    }
    public String getWorld(){
      return "world";
    }
  }
;
  try {
    shouldCompileTo(string,hash,"b1. goodbye! 2. GOODBYE! cruel world!");
  }
 catch (  Throwable ex) {
    shouldCompileTo(string,hash,"2. GOODBYE! b1. goodbye! cruel world!");
  }
}
