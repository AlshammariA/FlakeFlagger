@Test @SuppressWarnings("unused") public void issue42() throws IOException {
  Object context=new Object(){
    public Object getFoo(){
      return new Object(){
        public String getTitle(){
          return "foo";
        }
        public Object getBar(){
          return new Object(){
            public String getTitle(){
              return null;
            }
            @Override public String toString(){
              return "bar";
            }
          }
;
        }
        @Override public String toString(){
          return "foo";
        }
      }
;
    }
  }
;
  shouldCompileTo("{{#foo}}{{title}} {{#bar}}{{title}}{{/bar}}{{/foo}}",context,"foo ");
}
