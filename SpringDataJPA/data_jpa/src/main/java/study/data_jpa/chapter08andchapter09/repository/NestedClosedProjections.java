package study.data_jpa.chapter08andchapter09.repository;

public interface NestedClosedProjections {
    String getUsername();
    TeamInfo getTeam();
    interface TeamInfo{
        String getName();
    }
}
