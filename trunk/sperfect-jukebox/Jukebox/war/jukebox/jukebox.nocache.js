function jukebox(){var cb='',_=' top: -1000px;',zb='" for "gwt:onLoadErrorFn"',xb='" for "gwt:onPropertyErrorFn"',ib='");',Ab='#',hc='.cache.js',Cb='/',Ib='//',$b='009C8B501269DC5D97C758640552BDA5',cc='7F07812676C66AC7140C43BB10563E6D',dc='9317404E5FBDA0C9CB983514C35E975E',gc=':',_b=':1',ac=':2',bc=':3',rb='::',vc=':moduleBase',bb='<!doctype html>',db='<html><head><\/head><body><\/body><\/html>',ub='=',Bb='?',ec='BA74E811788C3EA0EC331043A81F98A0',wb='Bad handler "',ab='CSS1Compat',gb='Chrome',fb='DOMContentLoaded',W='DUMMY',fc='E42A8C27AA4EB3B53E574A2A472510C2',uc='Ignoring non-whitelisted Dev Mode URL: ',tc='__gwtDevModeHook:jukebox',sc='_gwt_dummy_',Hb='base',Fb='baseUrl',R='begin',X='body',Q='bootstrap',Jb='bstplayer.platform',Eb='clear.cache.gif',tb='content',oc='custom-control-styles.css',pc='end',hb='eval("',rc='file:',Vb='gecko',Wb='gecko1_8',S='gwt.codesvr.jukebox=',T='gwt.codesvr=',nc='gwt/standard/standard.css',yb='gwt:onLoadErrorFn',vb='gwt:onPropertyErrorFn',sb='gwt:property',nb='head',lc='href',qc='http:',Sb='ie10',Ub='ie8',Tb='ie9',Y='iframe',Db='img',kb='javascript',Z='javascript:""',U='jukebox',Zb='jukebox.devmode.js',Gb='jukebox.nocache.js',qb='jukebox::',ic='link',Kb='linux',mc='loadExternalRefs',Lb='mac',ob='meta',mb='moduleRequested',lb='moduleStartup',Rb='msie',pb='name',Mb='other',$='position:absolute; width:0; height:0; border:none; left: -1000px;',jc='rel',Qb='safari',jb='script',Yb='selectingPermutation',V='startup',kc='stylesheet',eb='undefined',Xb='unknown',Ob='user.agent',Pb='webkit',Nb='win';var o=window;var p=document;r(Q,R);function q(){var a=o.location.search;return a.indexOf(S)!=-1||a.indexOf(T)!=-1}
function r(a,b){if(o.__gwtStatsEvent){o.__gwtStatsEvent({moduleName:U,sessionId:o.__gwtStatsSessionId,subSystem:V,evtGroup:a,millis:(new Date).getTime(),type:b})}}
jukebox.__sendStats=r;jukebox.__moduleName=U;jukebox.__errFn=null;jukebox.__moduleBase=W;jukebox.__softPermutationId=0;jukebox.__computePropValue=null;jukebox.__getPropMap=null;jukebox.__gwtInstallCode=function(){};jukebox.__gwtStartLoadingFragment=function(){return null};var s=function(){return false};var t=function(){return null};__propertyErrorFunction=null;var u=o.__gwt_activeModules=o.__gwt_activeModules||{};u[U]={moduleName:U};var v;function w(){B();return v}
function A(){B();return v.getElementsByTagName(X)[0]}
function B(){if(v){return}var a=p.createElement(Y);a.src=Z;a.id=U;a.style.cssText=$+_;a.tabIndex=-1;p.body.appendChild(a);v=a.contentDocument;if(!v){v=a.contentWindow.document}v.open();var b=document.compatMode==ab?bb:cb;v.write(b+db);v.close()}
function C(k){function l(a){function b(){if(typeof p.readyState==eb){return typeof p.body!=eb&&p.body!=null}return /loaded|complete/.test(p.readyState)}
var c=b();if(c){a();return}function d(){if(!c){c=true;a();if(p.removeEventListener){p.removeEventListener(fb,d,false)}if(e){clearInterval(e)}}}
if(p.addEventListener){p.addEventListener(fb,d,false)}var e=setInterval(function(){if(b()){d()}},50)}
function m(c){function d(a,b){a.removeChild(b)}
var e=A();var f=w();var g;if(navigator.userAgent.indexOf(gb)>-1&&window.JSON){var h=f.createDocumentFragment();h.appendChild(f.createTextNode(hb));for(var i=0;i<c.length;i++){var j=window.JSON.stringify(c[i]);h.appendChild(f.createTextNode(j.substring(1,j.length-1)))}h.appendChild(f.createTextNode(ib));g=f.createElement(jb);g.language=kb;g.appendChild(h);e.appendChild(g);d(e,g)}else{for(var i=0;i<c.length;i++){g=f.createElement(jb);g.language=kb;g.text=c[i];e.appendChild(g);d(e,g)}}}
jukebox.onScriptDownloaded=function(a){l(function(){m(a)})};r(lb,mb);var n=p.createElement(jb);n.src=k;p.getElementsByTagName(nb)[0].appendChild(n)}
jukebox.__startLoadingFragment=function(a){return G(a)};jukebox.__installRunAsyncCode=function(a){var b=A();var c=w().createElement(jb);c.language=kb;c.text=a;b.appendChild(c);b.removeChild(c)};function D(){var c={};var d;var e;var f=p.getElementsByTagName(ob);for(var g=0,h=f.length;g<h;++g){var i=f[g],j=i.getAttribute(pb),k;if(j){j=j.replace(qb,cb);if(j.indexOf(rb)>=0){continue}if(j==sb){k=i.getAttribute(tb);if(k){var l,m=k.indexOf(ub);if(m>=0){j=k.substring(0,m);l=k.substring(m+1)}else{j=k;l=cb}c[j]=l}}else if(j==vb){k=i.getAttribute(tb);if(k){try{d=eval(k)}catch(a){alert(wb+k+xb)}}}else if(j==yb){k=i.getAttribute(tb);if(k){try{e=eval(k)}catch(a){alert(wb+k+zb)}}}}}t=function(a){var b=c[a];return b==null?null:b};__propertyErrorFunction=d;jukebox.__errFn=e}
function F(){function e(a){var b=a.lastIndexOf(Ab);if(b==-1){b=a.length}var c=a.indexOf(Bb);if(c==-1){c=a.length}var d=a.lastIndexOf(Cb,Math.min(c,b));return d>=0?a.substring(0,d+1):cb}
function f(a){if(a.match(/^\w+:\/\//)){}else{var b=p.createElement(Db);b.src=a+Eb;a=e(b.src)}return a}
function g(){var a=t(Fb);if(a!=null){return a}return cb}
function h(){var a=p.getElementsByTagName(jb);for(var b=0;b<a.length;++b){if(a[b].src.indexOf(Gb)!=-1){return e(a[b].src)}}return cb}
function i(){var a=p.getElementsByTagName(Hb);if(a.length>0){return a[a.length-1].href}return cb}
function j(){var a=p.location;return a.href==a.protocol+Ib+a.host+a.pathname+a.search+a.hash}
var k=g();if(k==cb){k=h()}if(k==cb){k=i()}if(k==cb&&j()){k=e(p.location.href)}k=f(k);return k}
function G(a){if(a.match(/^\//)){return a}if(a.match(/^[a-zA-Z]+:\/\//)){return a}return jukebox.__moduleBase+a}
function H(){var f=[];var g=0;function h(a,b){var c=f;for(var d=0,e=a.length-1;d<e;++d){c=c[a[d]]||(c[a[d]]=[])}c[a[e]]=b}
var i=[];var j=[];function k(a){var b=j[a](),c=i[a];if(b in c){return b}var d=[];for(var e in c){d[c[e]]=e}if(__propertyErrorFunc){__propertyErrorFunc(a,d,b)}throw null}
j[Jb]=function(){var a=navigator.platform.toLowerCase();if(a.indexOf(Kb)!=-1){return Kb}else if(a.indexOf(Lb)!=-1){return Lb}else if(a.indexOf(Mb)!=-1){return Mb}else if(a.indexOf(Nb)!=-1){return Nb}else{return Mb}};i[Jb]={linux:0,mac:1,other:2,win:3};j[Ob]=function(){var b=navigator.userAgent.toLowerCase();var c=function(a){return parseInt(a[1])*1000+parseInt(a[2])};if(function(){return b.indexOf(Pb)!=-1}())return Qb;if(function(){return b.indexOf(Rb)!=-1&&p.documentMode>=10}())return Sb;if(function(){return b.indexOf(Rb)!=-1&&p.documentMode>=9}())return Tb;if(function(){return b.indexOf(Rb)!=-1&&p.documentMode>=8}())return Ub;if(function(){return b.indexOf(Vb)!=-1}())return Wb;return Xb};i[Ob]={gecko1_8:0,ie10:1,ie8:2,ie9:3,safari:4};s=function(a,b){return b in i[a]};jukebox.__getPropMap=function(){var a={};for(var b in i){if(i.hasOwnProperty(b)){a[b]=k(b)}}return a};jukebox.__computePropValue=k;o.__gwt_activeModules[U].bindings=jukebox.__getPropMap;r(Q,Yb);if(q()){return G(Zb)}var l;try{h([Kb,Ub],$b);h([Lb,Ub],$b);h([Mb,Ub],$b);h([Nb,Ub],$b);h([Kb,Ub],$b+_b);h([Lb,Ub],$b+_b);h([Mb,Ub],$b+_b);h([Nb,Ub],$b+_b);h([Kb,Ub],$b+ac);h([Lb,Ub],$b+ac);h([Mb,Ub],$b+ac);h([Nb,Ub],$b+ac);h([Kb,Ub],$b+bc);h([Lb,Ub],$b+bc);h([Mb,Ub],$b+bc);h([Nb,Ub],$b+bc);h([Kb,Sb],cc);h([Lb,Sb],cc);h([Mb,Sb],cc);h([Nb,Sb],cc);h([Kb,Sb],cc+_b);h([Lb,Sb],cc+_b);h([Mb,Sb],cc+_b);h([Nb,Sb],cc+_b);h([Kb,Sb],cc+ac);h([Lb,Sb],cc+ac);h([Mb,Sb],cc+ac);h([Nb,Sb],cc+ac);h([Kb,Sb],cc+bc);h([Lb,Sb],cc+bc);h([Mb,Sb],cc+bc);h([Nb,Sb],cc+bc);h([Kb,Qb],dc);h([Lb,Qb],dc);h([Mb,Qb],dc);h([Nb,Qb],dc);h([Kb,Qb],dc+_b);h([Lb,Qb],dc+_b);h([Mb,Qb],dc+_b);h([Nb,Qb],dc+_b);h([Kb,Qb],dc+ac);h([Lb,Qb],dc+ac);h([Mb,Qb],dc+ac);h([Nb,Qb],dc+ac);h([Kb,Qb],dc+bc);h([Lb,Qb],dc+bc);h([Mb,Qb],dc+bc);h([Nb,Qb],dc+bc);h([Kb,Wb],ec);h([Lb,Wb],ec);h([Mb,Wb],ec);h([Nb,Wb],ec);h([Kb,Wb],ec+_b);h([Lb,Wb],ec+_b);h([Mb,Wb],ec+_b);h([Nb,Wb],ec+_b);h([Kb,Wb],ec+ac);h([Lb,Wb],ec+ac);h([Mb,Wb],ec+ac);h([Nb,Wb],ec+ac);h([Kb,Wb],ec+bc);h([Lb,Wb],ec+bc);h([Mb,Wb],ec+bc);h([Nb,Wb],ec+bc);h([Kb,Tb],fc);h([Lb,Tb],fc);h([Mb,Tb],fc);h([Nb,Tb],fc);h([Kb,Tb],fc+_b);h([Lb,Tb],fc+_b);h([Mb,Tb],fc+_b);h([Nb,Tb],fc+_b);h([Kb,Tb],fc+ac);h([Lb,Tb],fc+ac);h([Mb,Tb],fc+ac);h([Nb,Tb],fc+ac);h([Kb,Tb],fc+bc);h([Lb,Tb],fc+bc);h([Mb,Tb],fc+bc);h([Nb,Tb],fc+bc);l=f[k(Jb)][k(Ob)];var m=l.indexOf(gc);if(m!=-1){g=parseInt(l.substring(m+1),10);l=l.substring(0,m)}}catch(a){}jukebox.__softPermutationId=g;return G(l+hc)}
function I(){if(!o.__gwt_stylesLoaded){o.__gwt_stylesLoaded={}}function c(a){if(!__gwt_stylesLoaded[a]){var b=p.createElement(ic);b.setAttribute(jc,kc);b.setAttribute(lc,G(a));p.getElementsByTagName(nb)[0].appendChild(b);__gwt_stylesLoaded[a]=true}}
r(mc,R);c(nc);c(oc);r(mc,pc)}
D();jukebox.__moduleBase=F();u[U].moduleBase=jukebox.__moduleBase;var J=H();if(o){var K=!!(o.location.protocol==qc||o.location.protocol==rc);o.__gwt_activeModules[U].canRedirect=K;function L(){var b=sc;try{o.sessionStorage.setItem(b,b);o.sessionStorage.removeItem(b);return true}catch(a){return false}}
if(K&&L()){var M=tc;var N=o.sessionStorage[M];if(!/^http:\/\/(localhost|127\.0\.0\.1)(:\d+)?\/.*$/.test(N)){if(N&&(window.console&&console.log)){console.log(uc+N)}N=cb}if(N&&!o[M]){o[M]=true;o[M+vc]=F();var O=p.createElement(jb);O.src=N;var P=p.getElementsByTagName(nb)[0];P.insertBefore(O,P.firstElementChild||P.children[0]);return false}}}I();r(Q,pc);C(J);return true}
jukebox.succeeded=jukebox();