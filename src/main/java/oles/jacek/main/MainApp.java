package oles.jacek.main;

import oles.jacek.alone.home.MainHomeAlone;
import oles.jacek.avalanche.rock.MainRockAvalanche;
import oles.jacek.remote.tv.MainTvRemote;

/**
 * Hello world!
 */
public class MainApp {

    public static void main(String[] args) {
        MainTvRemote.main(args);
        MainRockAvalanche.main(args);
        MainHomeAlone.main(args);
    }
}
