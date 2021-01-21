@Test public void testMatching_star(){
  assertThat("*").matches("a","abc","298347829473928423","abc12345","").doesNotMatch("/","/abc");
  assertThat("/*").matches("/a","/abcd","/abc123","/").doesNotMatch("/foo/bar");
  assertThat("/*/*/*").matches("/a/b/c","/foo/bar/baz").doesNotMatch("/foo/bar","/foo/bar/baz/abc");
  assertThat("/*/bar").matches("/foo/bar","/abc/bar").doesNotMatch("/bar");
  assertThat("/foo/*").matches("/foo/bar","/foo/baz").doesNotMatch("/foo","foo/bar","/foo/bar/baz");
  assertThat("/foo*/ba*").matches("/food/bar","/fool/bat","/foo/ba","/foot/ba","/foo/bar","/foods/bartender").doesNotMatch("/food/baz/bar");
  assertThat("*.java").matches("Foo.java","Bar.java","GlobPatternTest.java","Foo.java.java",".java").doesNotMatch("Foo.jav","Foo","java.Foo","Foo.java.");
  assertThat("Foo.*").matches("Foo.java","Foo.txt","Foo.tar.gz","Foo.Foo.","Foo.").doesNotMatch("Foo",".Foo");
  assertThat("*/*.java").matches("foo/Bar.java","foo/.java");
  assertThat("*/Bar.*").matches("foo/Bar.java");
  assertThat(".*").matches(".bashrc",".bash_profile");
  assertThat("*.............").matches("............a............a..............a.............a............a.........." + ".........................................................a....................");
  assertThat("*.............*..").matches("............a............a..............a.............a............a.........." + "..........a...................................................................");
  assertThat(".................*........*.*.....*....................*..............*").matches(".................................abc.........................................." + ".............................................................................." + ".............................................................................."+ ".............................................12..............................."+ ".........................................................................hello"+ "..............................................................................");
}
