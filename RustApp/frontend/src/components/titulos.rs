use yew::prelude::*;

#[derive(Debug)]
pub struct TituloPrincipal;

#[derive(Debug, Default, Properties, PartialEq)]
pub struct TituloPrincipalProps {
    pub titulo: String,
}

impl Component for TituloPrincipal {
    type Message = ();
    type Properties = TituloPrincipalProps;

    fn create(ctx: &Context<Self>) -> Self {
        Self
    }

    fn view(&self, ctx: &Context<Self>) -> Html {
        html! {
            <div class = {classes!("columns")}>
                <div class = {classes!("column", "is-full")}>
                    <h1 class = {classes!("title", "has-text-centered")}>{ctx.props().titulo.clone()}</h1>
                </div>
            </div>
        }
    }
}