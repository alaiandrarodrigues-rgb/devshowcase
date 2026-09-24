package br.edu.uapi.devshowcase;

public record ProjectResponse(
    Long id,
    String name,
    String description,
    String technology,
    Integer upvotes,
    Double averageRating
) {
    public static ProjectResponse from(Project p) {
        return new ProjectResponse(p.getId(), p.getName(), p.getDescription(),
            p.getTechnology(), p.getUpvotes(), p.getAverageRating());
    }
}
