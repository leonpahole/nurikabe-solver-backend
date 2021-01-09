rootProject.name = "nurikabe-solver-backend"

includeBuild("../solver")  {
    dependencySubstitution {
        substitute(module("com.leonpahole:nurikabe-solver")).with(project(":"))
    }
}
