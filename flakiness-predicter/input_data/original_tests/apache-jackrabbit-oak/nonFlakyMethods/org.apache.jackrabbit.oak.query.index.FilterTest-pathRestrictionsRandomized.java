@Test public void pathRestrictionsRandomized() throws Exception {
  ArrayList<String> paths=new ArrayList<String>();
  paths.add("/");
  for (int i='a'; i <= 'c'; i++) {
    String p1="/" + (char)i;
    paths.add(p1);
    for (int j='a'; j <= 'c'; j++) {
      String p2="/" + (char)j;
      paths.add(p1 + p2);
      for (int k='a'; k <= 'c'; k++) {
        String p3="/" + (char)k;
        paths.add(p1 + p2 + p3);
      }
    }
  }
  Random r=new Random(1);
  for (int i=0; i < 10000; i++) {
    String p1=paths.get(r.nextInt(paths.size()));
    String p2=paths.get(r.nextInt(paths.size()));
    Filter.PathRestriction r1=Filter.PathRestriction.values()[r.nextInt(Filter.PathRestriction.values().length)];
    Filter.PathRestriction r2=Filter.PathRestriction.values()[r.nextInt(Filter.PathRestriction.values().length)];
    FilterImpl f1=new FilterImpl();
    f1.restrictPath(p1,r1);
    FilterImpl f2=new FilterImpl();
    f2.restrictPath(p2,r2);
    FilterImpl fc=new FilterImpl();
    fc.restrictPath(p1,r1);
    fc.restrictPath(p2,r2);
    int tooMany=0;
    for (    String p : paths) {
      boolean expected=f1.testPath(p) && f2.testPath(p);
      boolean got=fc.testPath(p);
      if (expected == got) {
      }
 else       if (expected && !got) {
        fc=new FilterImpl();
        fc.restrictPath(p1,r1);
        fc.restrictPath(p2,r2);
        fail("not matched: " + p1 + "/"+ r1.name()+ " && "+ p2+ "/"+ r2.name());
      }
 else {
        tooMany++;
      }
    }
    if (tooMany > 3) {
      fail("too many matches: " + p1 + "/"+ r1.name()+ " && "+ p2+ "/"+ r2.name()+ " superfluous: "+ tooMany);
    }
  }
}
