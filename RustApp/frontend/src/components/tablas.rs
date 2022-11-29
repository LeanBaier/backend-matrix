use yew::prelude::*;

pub struct TablaTragos;

#[derive(Debug, Default, Properties, PartialEq)]
pub struct TablaTragosProp {
    pub titulo: String,
    pub cantidad: u16,
}

struct Data {
    nombre: String,
    apellido: String,
    edad: String,
}

impl Component for TablaTragos {
    type Message = ();
    type Properties = TablaTragosProp;

    fn create(ctx: &Context<Self>) -> Self {
        Self
    }

    fn view(&self, ctx: &Context<Self>) -> Html {
        let data = vec!(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        let data = data.iter().map(|v| {
            Data {
                nombre: format!("Nombre {v}"),
                apellido: format!("Apellido {v}"),
                edad: format!("{v}"),
            }
        });
        html! {
            <div>
                <div class={classes!("columns")}>
                <p class = {classes!("is-size-3")}>{ctx.props().titulo.clone()}</p>
            </div>
                <div>
                     <table class = {classes!("table", "is-hoverable", "is-fullwidth")}>
                        <thead>
                            <th><abbr title={"Nombre"}>{"Nombre"}</abbr></th>
                            <th><abbr title = {"Apellido"}>{"Apellido"}</abbr></th>
                            <th><abbr title = {"Edad"}>{"Edad"}</abbr></th>
                        </thead>
                        <tbody>
                            {
                                data.into_iter().map(|dato| {
                                html!{
                                    <tr>
                                        <td>{dato.nombre.clone()}</td>
                                        <td>{dato.apellido.clone()}</td>
                                        <td>{dato.edad}</td>
                                    </tr>
                                }
                            }).collect::<Html>()
                            }
                        </tbody>
                    </table>
                </div>

            </div>
        }
    }
}